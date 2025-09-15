/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.services.questions;

import com.ntt.pojo.Choice;
import com.ntt.pojo.Level;
import com.ntt.pojo.Question;
import com.ntt.utils.JdbcConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN THUAN
 */
public class QuestionServices extends BaseQuestionServices{
    @Override
    public String getSQL(List<Object> params) {
        return "SELECT * FROM question WHERE 1=1";

    }
    
//    public List<Question> getQuestions(String kw) throws SQLException {
//        // Mo ket noi
//        Connection conn = JdbcConnector.getInstance().connect();
//
//        // Truy van
//        PreparedStatement stm = conn.prepareCall("SELECT * FROM question WHERE content like concat ('%', ?, '%')"); // Thuc thi truy van
//        stm.setString(1, kw);
//
//        ResultSet rs = stm.executeQuery();
//
//        List<Question> questions = new ArrayList<>();
//        while (rs.next()) {
//            Question q = new Question.Builder(rs.getInt("id"), rs.getString("content")).build();
//            questions.add(q);
//        }
//        return questions;
//    }

//    public List<Question> getQuestions(int num) throws SQLException {
//        // Mo ket noi
//        Connection conn = JdbcConnector.getInstance().connect();
//
//        // Truy van
//        PreparedStatement stm = conn.prepareCall("SELECT * FROM question ORDER BY rand() LIMIT ?"); // Thuc thi truy van
//        stm.setInt(1, num);
//
//        ResultSet rs = stm.executeQuery();
//
//        List<Question> questions = new ArrayList<>();
//        while (rs.next()) {
//            Question q = new Question.Builder(rs.getInt("id"), rs.getString("content"))
//                    .addAllChoices(this.getChoiceByQuestionId(rs.getInt("id"))).build();
//            questions.add(q);
//        }
//        return questions;
//    }

//    public List<Choice> getChoiceByQuestionId(int questionId) throws SQLException {
//        // Mo ket noi
//        Connection conn = JdbcConnector.getInstance().connect();
//
//        // Truy van
//        PreparedStatement stm = conn.prepareCall("SELECT * FROM choice WHERE question_id=?"); // Thuc thi truy van
//        stm.setInt(1, questionId);
//
//        ResultSet rs = stm.executeQuery();
//
//        List<Choice> choices = new ArrayList<>();
//        while (rs.next()) {
//            Choice c = new Choice(rs.getInt("id"), rs.getString("content"), rs.getBoolean("is_correct"));
//            choices.add(c);
//        }
//        return choices;
//    }



}
