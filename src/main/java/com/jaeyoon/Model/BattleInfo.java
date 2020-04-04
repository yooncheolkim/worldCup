package com.jaeyoon.Model;


import java.util.List;

public class BattleInfo {

    String leftNum;
    String rightNum;

    String leftDesc;
    String rightDesc;

    List<String> remain;

    List<String> selected;

    int currLevel;

    int currBattleCnt;

    int halfCurrLevel;

    public String getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(String leftNum) {
        this.leftNum = leftNum;
    }

    public String getRightNum() {
        return rightNum;
    }

    public void setRightNum(String rightNum) {
        this.rightNum = rightNum;
    }

    public List<String> getRemain() {
        return remain;
    }

    public void setRemain(List<String> remain) {
        this.remain = remain;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }

    public int getCurrBattleCnt() {
        return currBattleCnt;
    }

    public void setCurrBattleCnt(int currBattleCnt) {
        this.currBattleCnt = currBattleCnt;
    }

    public int getHalfCurrLevel() {
        return halfCurrLevel;
    }

    public void setHalfCurrLevel(int halfCurrLevel) {
        this.halfCurrLevel = halfCurrLevel;
    }

    public String getLeftDesc() {
        return leftDesc;
    }

    public void setLeftDesc(String leftDesc) {
        this.leftDesc = leftDesc;
    }

    public String getRightDesc() {
        return rightDesc;
    }

    public void setRightDesc(String rightDesc) {
        this.rightDesc = rightDesc;
    }
}
