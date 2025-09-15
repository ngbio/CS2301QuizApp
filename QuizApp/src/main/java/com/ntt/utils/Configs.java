/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.utils;

import com.ntt.services.CategoryServices;
import com.ntt.services.LevelServices;
import com.ntt.services.questions.BaseQuestionServices;
import com.ntt.services.questions.QuestionServices;
import com.ntt.services.questions.UpdateQuestionServices;

/**
 *
 * @author NGUYEN THUAN
 */
public class Configs {

    public static final BaseQuestionServices questionServices = new QuestionServices();
    public static final LevelServices levelServices = new LevelServices();
    public static final UpdateQuestionServices uQuestionServices = new UpdateQuestionServices();
    public static final CategoryServices cateServices = new CategoryServices();
    
    public static final int NUM_QUESTIONS = 10;
    public static final double[] RATES = {0.2, 0.4, 0.4};
}
