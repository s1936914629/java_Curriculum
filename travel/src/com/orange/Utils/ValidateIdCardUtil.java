package com.orange.Utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIdCardUtil {
 
    final static Map<Integer, String> zoneNum = new HashMap<Integer, String>();
 
    static {
        	zoneNum.put(11, "����");
            zoneNum.put(12, "���");
            zoneNum.put(13, "�ӱ�");
            zoneNum.put(14, "ɽ��");
            zoneNum.put(15, "���ɹ�");
            zoneNum.put(21, "����");
            zoneNum.put(22, "����");
            zoneNum.put(23, "������");
            zoneNum.put(31, "�Ϻ�");
            zoneNum.put(32, "����");
            zoneNum.put(33, "�㽭");
            zoneNum.put(34, "����");
            zoneNum.put(35, "����");
            zoneNum.put(36, "����");
            zoneNum.put(37, "ɽ��");
            zoneNum.put(41, "����");
            zoneNum.put(42, "����");
            zoneNum.put(43, "����");
            zoneNum.put(44, "�㶫");
            zoneNum.put(45, "����");
            zoneNum.put(46, "����");
            zoneNum.put(50, "����");
            zoneNum.put(51, "�Ĵ�");
            zoneNum.put(52, "����");
            zoneNum.put(53, "����");
            zoneNum.put(54, "����");
            zoneNum.put(61, "����");
            zoneNum.put(62, "����");
            zoneNum.put(63, "�ຣ");
            zoneNum.put(64, "����");
            zoneNum.put(65, "�½�");
            zoneNum.put(71, "̨��");
            zoneNum.put(81, "���");
            zoneNum.put(82, "����");
            zoneNum.put(91, "���");
    }
 
    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    final static int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
            5, 8, 4, 2};
 
    /**
     * ���֤��֤
     *
     * @param certNo ��������
     * @return �Ƿ���Ч null��"" ����false
     */
    public static boolean isIDCard(String certNo) {
        if (certNo == null || (certNo.length() != 15 && certNo.length() != 18))
            return false;
        final char[] cs = certNo.toUpperCase().toCharArray();
        //У��λ��
        int power = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i == cs.length - 1 && cs[i] == 'X')
                break;//���һλ���� ��X��x
            if (cs[i] < '0' || cs[i] > '9')
                return false;
            if (i < cs.length - 1) {
                power += (cs[i] - '0') * POWER_LIST[i];
            }
        }
 
        //У����λ��
        if (!zoneNum.containsKey(Integer.valueOf(certNo.substring(0, 2)))) {
            return false;
        }
 
        //У�����
        String year = null;
        year = certNo.length() == 15 ? getIdcardCalendar(certNo) : certNo.substring(6, 10);
 
 
        final int iyear = Integer.parseInt(year);
        if (iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR))
            return false;//1900���PASS�����������PASS
 
        //У���·�
        String month = certNo.length() == 15 ? certNo.substring(8, 10) : certNo.substring(10, 12);
        final int imonth = Integer.parseInt(month);
        if (imonth < 1 || imonth > 12) {
            return false;
        }
 
        //У������
        String day = certNo.length() == 15 ? certNo.substring(10, 12) : certNo.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if (iday < 1 || iday > 31)
            return false;
 
        //У��"У����"
        if (certNo.length() == 15)
            return true;
        return cs[cs.length - 1] == PARITYBIT[power % 11];
    }
 
    private static String getIdcardCalendar(String certNo) {
        // ��ȡ����������
        String birthday = certNo.substring(6, 12);
        SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");
        Date birthdate = null;
        try {
            birthdate = ft.parse(birthday);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        Calendar cday = Calendar.getInstance();
        cday.setTime(birthdate);
        String year = String.valueOf(cday.get(Calendar.YEAR));
        return year;
    }
    
    
 
    public static void main(String[] args) {
        boolean istrue = isIDCard("532123200006020056");
        System.out.println(istrue);
        
        String phone = "13123456789";
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if(phone.length() != 11){
            System.out.println("�ֻ���ӦΪ11λ��");
        }else{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(isMatch){
                System.out.println("�����ֻ���" + phone + "����ȷ��ʽ@����@");
            } else {
                System.out.println("�����ֻ���" + phone + "�Ǵ����ʽ������");
            }
        }
    }
    
    
 
}