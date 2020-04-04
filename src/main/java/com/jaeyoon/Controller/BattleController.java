package com.jaeyoon.Controller;

import com.jaeyoon.Model.BattleInfo;
import com.jaeyoon.Model.ImageContents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class BattleController {


    //받아야 되는거
    // remain : 현재 남은애들 -> 이걸로 몇강 인지, 몇개 남앗는지 계산
    //
    @PostMapping("/hello/battle")
    public @ResponseBody BattleInfo hello(Model model, @RequestBody BattleInfo battle) {

//        //1강이 되었을때,,
//        if(battle.getCurrLevel() == 2){
//            String winner = battle.getRemain().get(0);
//            model.addAttribute("winnerImage",winner + ".jpg");
//            BattleInfo biLast = new BattleInfo();
//            model.addAttribute("winner", winner);
//            model.addAttribute("desc",ImageContents.ImageDesc[Integer.parseInt(winner)]);
//        }

        List<String> remain;
        List<String> selected = battle.getSelected();
        BattleInfo battleInfo = new BattleInfo();
        int halfCurrLeverl = 0;

        //현재 레벨의 모든 대결 완료
        if(battle.getCurrBattleCnt()*2 == battle.getCurrLevel()){
            remain = selected;
            battleInfo.setCurrLevel(remain.size());
            battle.setCurrBattleCnt(0);
            halfCurrLeverl = remain.size()/2;
            selected = new ArrayList<>();
        }
        else{
            remain= battle.getRemain();
            battleInfo.setCurrLevel(battle.getCurrLevel());
            halfCurrLeverl = battle.getCurrLevel()/2;
        }

        Random generator = new Random();
        int num1 = generator.nextInt(remain.size());
        String leftImageNum = remain.get(num1);
        remain.remove(num1);
        battleInfo.setLeftDesc(ImageContents.ImageDesc[Integer.parseInt(leftImageNum)]);

        int num2 = generator.nextInt(remain.size());
        String rightImageNum = remain.get(num2);
        remain.remove(num2);
        battleInfo.setRightDesc(ImageContents.ImageDesc[Integer.parseInt(rightImageNum)]);

        battleInfo.setLeftNum(leftImageNum);
        battleInfo.setRightNum(rightImageNum);
        battleInfo.setCurrBattleCnt(battle.getCurrBattleCnt() + 1);
        battleInfo.setHalfCurrLevel(halfCurrLeverl);
        battleInfo.setRemain(remain);
        battleInfo.setSelected(selected);

        return battleInfo;
    }

    @GetMapping("/hello")
    public String init(Model model){
        //처음 실행될때,, 64강
        List<String> remain = new ArrayList<>();
        List<String> selected = new ArrayList<>();

        for(int i = 1; i <= 64; i++){
            remain.add(Integer.toString(i));
        }

        Random generator = new Random();
        int num1 = generator.nextInt(remain.size());
        String leftImageNum = remain.get(num1);
        remain.remove(num1);

        int num2 = generator.nextInt(remain.size());
        String rightImageNum = remain.get(num2);
        remain.remove(num2);

        model.addAttribute("leftImage","/images/" + leftImageNum+".jpg");
        model.addAttribute("rightImage","/images/" + rightImageNum+".jpg");
        model.addAttribute("leftNum",leftImageNum);
        model.addAttribute("rightNum",rightImageNum);
        model.addAttribute("currLevel", "64");
        model.addAttribute("currBattleCnt","1");
        model.addAttribute("halfCurrLevel", "32");
        model.addAttribute("remain", remain);
        model.addAttribute("selected", selected);
        model.addAttribute("leftDesc",ImageContents.ImageDesc[Integer.parseInt(leftImageNum)]);
        model.addAttribute("rightDesc",ImageContents.ImageDesc[Integer.parseInt(rightImageNum)]);

        return "battle";
    }




}
