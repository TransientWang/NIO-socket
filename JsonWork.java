package haha.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王扶摇
 * @Title: JsonWork
 * @ProjectName test
 * @date 2018/8/27 18:05
 */

public class JsonWork {
      String code;
      String msg;
       List<aa> resultList = new ArrayList<>();

    @Override
    public String toString() {
        return "JsonWork{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", resultList=" + resultList +
                '}';
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<aa> getResultList() {
        return resultList;
    }

    public void setResultList(List<aa> resultList) {
        this.resultList = resultList;
    }
}
