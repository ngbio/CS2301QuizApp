/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.services.exam;

import com.ntt.pojo.Question;
import com.ntt.services.questions.BaseQuestionServices;
import com.ntt.services.questions.LimitedQuestionServicesDecorator;
import com.ntt.utils.Configs;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author THUAN
 */
public class SpecificStrategy extends ExamStrategy{
    private int num;

    public SpecificStrategy(int num) {
        this.num = num;
    }
    
    
    @Override
    public List<Question> getQuetions() throws SQLException {
        BaseQuestionServices s = new LimitedQuestionServicesDecorator(Configs.questionServices, num);
        return s.list();
    }
    
}
