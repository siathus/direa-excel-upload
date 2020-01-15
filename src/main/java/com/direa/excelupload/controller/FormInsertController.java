package com.direa.excelupload.controller;

import com.direa.excelupload.vo.ClientcallVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FormInsertController {

    ClientcallVO vo = new ClientcallVO();

    @GetMapping("/insertForm.do")
    public String insertForm(HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        return "/insertForm";
    }

    @RequestMapping("/checkParam")
    public String checkParam(

            @ModelAttribute("clientName")String clientName,
            @ModelAttribute("receiverName")String receiverName,
            @ModelAttribute("callType")String callType,
            @ModelAttribute("solutionType")String solutionType,
            @ModelAttribute("riskLevel")String riskLevel,
            @ModelAttribute("receivedContents")String receivedContents,
            @ModelAttribute("situation")String situation,
            @ModelAttribute("occurredTime")String occurredTime,
            @ModelAttribute("currentStatus")String currentStatus,
            @ModelAttribute("additionalSupport")String additionalSupport, HttpServletResponse request
            ){
            vo.setSolutionType(solutionType);
            vo.setClientName(clientName);
            vo.setReceiverName(receiverName);
            vo.setCallType(callType);
            vo.setRiskLevel(riskLevel);
            vo.setReceivedContents(receivedContents);
            vo.setSituation(situation);
            vo.setOccurredTime(occurredTime);
            vo.setCurrentStatus(currentStatus);
            vo.setAdditionalSupport(additionalSupport);


        System.out.println("clientName  :"+vo.getClientName() );
        System.out.println("receiverName  :"+vo.getReceiverName());
        System.out.println("callType  :"+vo.getCallType() );
        System.out.println("solutionType  :"+vo.getSolutionType());
        System.out.println("riskLevel  :"+vo.getRiskLevel() );
        System.out.println("receivedContents  :"+ vo.getReceivedContents() );
        System.out.println("situation  : "+vo.getSituation() );
        System.out.println("occurredTime  :"+vo.getOccurredTime());
        System.out.println("currentStatus  :"+vo.getCurrentStatus());
        System.out.println("additionalSupport :"+vo.getAdditionalSupport() );


        return "/checkParam";
    }

}
