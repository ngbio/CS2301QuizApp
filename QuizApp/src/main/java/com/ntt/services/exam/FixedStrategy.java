/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.services.exam;

import com.ntt.pojo.Question;
import com.ntt.services.questions.BaseQuestionServices;
import com.ntt.services.questions.LevelQuestionServicesDecorator;
import com.ntt.services.questions.LimitedQuestionServicesDecorator;
import com.ntt.utils.Configs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THUAN
 */
public class FixedStrategy extends ExamStrategy {

    @Override
    public List<Question> getQuetions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        
        for(int i = 0; i < Configs.RATES.length; i++){
            BaseQuestionServices s = new LimitedQuestionServicesDecorator(new LevelQuestionServicesDecorator(Configs.questionServices, i + 1), (int)( Configs.NUM_QUESTIONS*Configs.RATES[i]));
            questions.addAll(s.list());
        }
        return questions;
    }
     
}
