package io.datajek.springmvc.junit.service;

import io.datajek.springmvc.junit.repository.ExamRepository;

public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public int findTotal() {
        //fetch student marks from a database
        int[] array = examRepository.getmarks();
        int sum = 0;

        for(int value : array) {
            sum += value;
        }
        return sum;
    }
}
