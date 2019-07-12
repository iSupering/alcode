package com.self.leet.code;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class EditOwnership {
    private static List<LineVO> lineVOList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> list = FileUtils.readLines(new File("/Users/jiechen/duty.txt"));

        System.out.println("*****注意核对数据*******");
        LineVO lineVO = null;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str == null || str.length() == 0) {
                continue;
            }
            System.out.println(str);

            if (str.toLowerCase().indexOf("user") >= 0 && str.toLowerCase().indexOf("id") >= 0) {
                if (lineVO == null) {
                    lineVO = new LineVO();
                }

                lineVO.userId = getValue(str.trim()).trim();
            }

            if (str.toLowerCase().indexOf("ownership") >= 0 && str.toLowerCase().indexOf("home") >= 0) {
                initOwnership(lineVO, getValue(str.trim()));
            }

            if (str.toLowerCase().indexOf("stay") >= 0 && str.toLowerCase().indexOf("length") >= 0) {
                String value = getValue(str).toLowerCase();
                if (value.indexOf("year") >= 0) {
                    String yearStr = value.substring(0, value.indexOf("year"));
                    int year = Integer.parseInt(yearStr.trim());
                    if (year >= 10) {
                        lineVO.stayLength = "10 Years+";
                        lineVO.stayLengthCode = "5";
                    } else if (year >= 5) {
                        lineVO.stayLength = "5-10 Years";
                        lineVO.stayLengthCode = "4";
                    } else if (year >= 1) {
                        lineVO.stayLength = "1-5 Years";
                        lineVO.stayLengthCode = "3";
                    }
                } else if (value.indexOf("month") >= 0) {
                    String monthStr = value.substring(0, value.indexOf("month"));
                    int month = Integer.parseInt(monthStr.trim());
                    if (month >= 6) {
                        lineVO.stayLength = "6-12 Months";
                        lineVO.stayLengthCode = "2";
                    } else {
                        lineVO.stayLength = "<6 Months";
                        lineVO.stayLengthCode = "1";
                    }
                }


                toSql(lineVO);
                lineVO = new LineVO();
                System.out.println("");
            }
        }
        System.out.println("*****注意核对数据*******");
        printAll();
    }


    private static Map<String, String> timeMap = new HashMap<>();

    {
        timeMap.put("10 Years+", "5");
        timeMap.put("5-10 Years", "4");
        timeMap.put("1-5 Years", "3");
        timeMap.put("6-12 Months", "2");
        timeMap.put("<6 Months", "1");

    }


    private static String getValue(String line) {
        return line.substring(line.indexOf(":") + 1);
    }

    private static void toSql(LineVO vo) {
        String sql = "注意核对数据sql--update trade.Persons set homeOwnership='"
                + vo.homeOwnership + "',homeOwnershipCode='"
                + vo.homeOwnershipCode + "',stayLength='"
                + vo.stayLength + "',stayLengthCode='"
                + vo.stayLengthCode + "' where accountId= "
                + vo.userId + ";";
        System.out.println(sql);
        lineVOList.add(vo);
    }

    static void printAll() {
        for (LineVO vo : lineVOList) {
            System.out.println("select  id,homeOwnership,homeOwnershipCode,stayLength,stayLengthCode from trade.Persons  where accountId=" + vo.userId + ";");
        }

        System.out.println("*********去提工单******");
        for (LineVO vo : lineVOList) {
            String sql = "update trade.Persons set homeOwnership='"
                    + vo.homeOwnership + "',homeOwnershipCode='"
                    + vo.homeOwnershipCode + "',stayLength='"
                    + vo.stayLength + "',stayLengthCode='"
                    + vo.stayLengthCode + "', updatedAt=updatedAt where accountId= "
                    + vo.userId + ";";
            System.out.println(sql);
        }
    }

    private static class LineVO {
        public String homeOwnership;
        public String homeOwnershipCode;
        public String stayLength;
        public String stayLengthCode;
        public String userId;

        public void clear() {
            homeOwnership = "";
            homeOwnershipCode = "";
            stayLength = "";
            stayLengthCode = "";
            userId = "";
        }

        /*


        shipMap.put("Company Provided", "1");
        shipMap.put("Mortgaged", "2");
        shipMap.put("Owner", "3");
        shipMap.put("Parents", "4");
        shipMap.put("Rented", "5");
        shipMap.put("Living with Relatives", "6");

         */

    }

    public static void initOwnership(LineVO lineVO, String ship) {
        ship = ship.toLowerCase();
        if (ship.indexOf("company") >= 0) {
            lineVO.homeOwnership = "Company Provided";
            lineVO.homeOwnershipCode = "1";
        } else if (ship.indexOf("mortgage") >= 0) {
            lineVO.homeOwnership = "Mortgaged";
            lineVO.homeOwnershipCode = "2";
        } else if (ship.indexOf("owner") >= 0) {
            lineVO.homeOwnership = "Owner";
            lineVO.homeOwnershipCode = "3";
        } else if (ship.indexOf("parents") >= 0) {
            lineVO.homeOwnership = "Parents";
            lineVO.homeOwnershipCode = "4";
        } else if (ship.indexOf("rente") >= 0) {
            lineVO.homeOwnership = "rented";
            lineVO.homeOwnershipCode = "5";
        } else if (ship.indexOf("living") >= 0) {
            lineVO.homeOwnership = "Living with Relatives";
            lineVO.homeOwnershipCode = "6";
        }
    }
}
