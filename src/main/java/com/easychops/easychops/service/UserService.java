package com.easychops.easychops.service;

import com.easychops.easychops.model.User;
import com.easychops.easychops.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User saveUser(User user) {
       return userRepository.save(user);
    }

    public static String test(List<Result> results) {
        String batchId = "";
        String appostrph = "'";
        for (Result result : results) {
//        while (result.next()) {
            batchId += appostrph + result.getString() + appostrph + ",";
        }

        batchId = batchId.substring(0, batchId.lastIndexOf(","));
        return batchId;
    }
}

class Result {
    Boolean next;
    String value;

    public Result(Boolean next, String value) {
        this.next = next;
        this.value = value;
    }

    public  boolean hasNext() {
        return this.next;
    }

    public String getString() {
        return this.value;
    }

    public static void main(String[] args) {
        Result result = new Result(true, "1");
        Result result1 = new Result(true, "2");
        Result result2= new Result(true, "3");
        Result result3 = new Result(true, "4");
        Result result4 = new Result(true, "5");
        Result result5 = new Result(true, "6");
        Result result6 = new Result(false, "7");
        List<Result> results = new ArrayList<>();
        results.add(result);
//        results.add(result1);
//        results.add(result2);
//        results.add(result3);
//        results.add(result4);
//        results.add(result5);
//        results.add(result6);

        System.out.println(UserService.test(results));
    }
}
