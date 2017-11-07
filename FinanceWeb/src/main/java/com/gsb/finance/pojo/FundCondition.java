package com.gsb.finance.pojo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/11/7
 * Time: 17:33
 * Description：
 */
public class FundCondition extends PageCondition {
    private String sharesCode1;
    private String sharesCode2;
    private String sharesCode3;
    private String sharesCode4;
    private String sharesCode5;
    private String sharesCode6;
    private String sharesCode7;
    private String sharesCode8;
    private String sharesCode9;
    private String sharesCode10;

    private List<String> sharesCodeList  =new ArrayList<String>();

    public String getSharesCode1() {
        return sharesCode1;
    }

    public void setSharesCode1(String sharesCode1) {
        this.sharesCode1 = sharesCode1;
        if(StringUtils.isNotBlank(this.getSharesCode1())){
            sharesCodeList.add(this.getSharesCode1());
        }
    }

    public String getSharesCode2() {
        return sharesCode2;
    }

    public void setSharesCode2(String sharesCode2) {
        this.sharesCode2 = sharesCode2;
        if(StringUtils.isNotBlank(this.getSharesCode2())){
            sharesCodeList.add(this.getSharesCode2());
        }
    }

    public String getSharesCode3() {
        return sharesCode3;
    }

    public void setSharesCode3(String sharesCode3) {
        this.sharesCode3 = sharesCode3;
        if(StringUtils.isNotBlank(this.getSharesCode3())){
            sharesCodeList.add(this.getSharesCode3());
        }
    }

    public String getSharesCode4() {
        return sharesCode4;
    }

    public void setSharesCode4(String sharesCode4) {
        this.sharesCode4 = sharesCode4;
        if(StringUtils.isNotBlank(this.getSharesCode4())){
            sharesCodeList.add(this.getSharesCode4());
        }
    }

    public String getSharesCode5() {
        return sharesCode5;
    }

    public void setSharesCode5(String sharesCode5) {
        this.sharesCode5 = sharesCode5;
        if(StringUtils.isNotBlank(this.getSharesCode5())){
            sharesCodeList.add(this.getSharesCode5());
        }
    }

    public String getSharesCode6() {
        return sharesCode6;
    }

    public void setSharesCode6(String sharesCode6) {
        this.sharesCode6 = sharesCode6;
        if(StringUtils.isNotBlank(this.getSharesCode6())){
            sharesCodeList.add(this.getSharesCode6());
        }
    }

    public String getSharesCode7() {
        return sharesCode7;
    }

    public void setSharesCode7(String sharesCode7) {
        this.sharesCode7 = sharesCode7;
        if(StringUtils.isNotBlank(this.getSharesCode7())){
            sharesCodeList.add(this.getSharesCode7());
        }
    }

    public String getSharesCode8() {
        return sharesCode8;
    }

    public void setSharesCode8(String sharesCode8) {
        this.sharesCode8 = sharesCode8;
        if(StringUtils.isNotBlank(this.getSharesCode8())){
            sharesCodeList.add(this.getSharesCode8());
        }
    }

    public String getSharesCode9() {
        return sharesCode9;
    }

    public void setSharesCode9(String sharesCode9) {
        this.sharesCode9 = sharesCode9;
        if(StringUtils.isNotBlank(this.getSharesCode9())){
            sharesCodeList.add(this.getSharesCode9());
        }
    }

    public String getSharesCode10() {
        return sharesCode10;
    }

    public void setSharesCode10(String sharesCode10) {
        this.sharesCode10 = sharesCode10;
        if(StringUtils.isNotBlank(this.getSharesCode10())){
            sharesCodeList.add(this.getSharesCode10());
        }
    }

    public List<String> getSharesCodeList() {
        return sharesCodeList;
    }

    public void setSharesCodeList(List<String> sharesCodeList) {
        this.sharesCodeList = sharesCodeList;
    }
}
