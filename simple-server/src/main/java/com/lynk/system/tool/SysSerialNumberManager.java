package com.lynk.system.tool;

/**
 * @author Lynk on 2016/12/29.
 */
public class SysSerialNumberManager {
    /*
    private static SysSerialNumberDao sysSerialNumberMapper;

    private static Map<String, SysSerialNumber> serialNumber = new HashMap<>();

    private static Map<String, BigDecimal> currentSN = new HashMap<>();
    private static Map<String, BigDecimal> currentMax = new HashMap<>();

    public static void init() {
        SysLogManager.getSystemLog().info("start init system serial number");
        SysSerialNumberManager.sysSerialNumberMapper = (SysSerialNumberDao) AppManager.getBean("sysSerialNumberMapper");
        List<SysSerialNumber> numbers = sysSerialNumberMapper.selectList(null);
        for (SysSerialNumber number: numbers) {
            serialNumber.put(number.getSnId(), number);
            currentSN.put(number.getSnId(), number.getSnCurrent());
            BigDecimal max = number.getSnCurrent().add(number.getSnIncrease().multiply(number.getSnSize()));
            currentMax.put(number.getSnId(), max);
            number.setSnCurrent(max);
            sysSerialNumberMapper.updateByPrimaryKey(number);
        }
        SysLogManager.getSystemLog().info("init system serial number finish");
    }

    private static void loadSerialNumberFromDB(String key) {
        SysLogManager.getSystemLog().info("loadSerialNumberFromDB: " + key);

        SysSerialNumber number = sysSerialNumberMapper.selectByPrimaryKey(key);
        serialNumber.put(number.getSnId(), number);
        currentSN.put(number.getSnId(), number.getSnCurrent());
        BigDecimal max = number.getSnCurrent().add(number.getSnIncrease().multiply(number.getSnSize()));
        currentMax.put(number.getSnId(), max);
        number.setSnCurrent(max);
        sysSerialNumberMapper.updateByPrimaryKey(number);
    }

    private static synchronized String createNextNumber(String key) {
        SysSerialNumber number = serialNumber.get(key);
        BigDecimal current = currentSN.get(key);
        BigDecimal max = currentMax.get(key);

        String serial = StringUtils.leftPad(current.toString(), number.getSnLength(), "0");

        current = current.add(number.getSnIncrease());
        currentSN.put(key, current);
        if (current.compareTo(max) >= 0) {
            loadSerialNumberFromDB(key);
        }
        return serial;
    }

    public static synchronized String nextId(String idType) {
        return DateUtil.getCurrentDate8() + createNextNumber(idType);
    }
    */
}
