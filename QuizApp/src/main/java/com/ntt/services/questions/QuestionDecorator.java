/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.services.questions;

/**
 *
 * @author THUAN
 */
public abstract class QuestionDecorator extends BaseQuestionServices{
    protected BaseQuestionServices decorator;

    public QuestionDecorator(BaseQuestionServices decorator) {
        this.decorator = decorator;
    }
    
    
}
