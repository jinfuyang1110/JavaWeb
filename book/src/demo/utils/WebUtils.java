package demo.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author Eric
 * @date 2021/1/18 16:13
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, int defaultNum) {
        try {
           return Integer.parseInt(str);
        } catch (NumberFormatException ignored) {

        }
        return defaultNum;
    }
}
