package test.filter.bean;

import java.net.URLEncoder;

public class UserInfoBean {
    /**
     * 用户IP
     */
    private String ip;
    /**
     * 访问次数
     */
    private Integer count;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return URLEncoder.encode( "UserInfoBean{" +
                "ip=" + ip +
                ",count=" + count +
                "}"
        );
    }
}
