package io.datajek.springmvc.junit.service;

import io.datajek.springmvc.junit.repository.ExamRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExamServiceStubTest {

    @Test
    void testFindTotal() {
        ExamService examService = new ExamService(new ExamRepositoryStubTest());
        int total = examService.findTotal();
        assertEquals(40,total);
    }

    @Test
    void testFindTotalWithMock(){
        ExamRepository examRepositoryMock = mock(ExamRepository.class);
        when(examRepositoryMock.getmarks()).thenReturn(new int[]{10,20,10});

        ExamService examService = new ExamService(examRepositoryMock);
        int total = examService.findTotal();
        assertEquals(40,total);
    }

    @Test
    void testFindTotalWithMock_EmptyArray(){
        ExamRepository examRepositoryMock = mock(ExamRepository.class);
        when(examRepositoryMock.getmarks()).thenReturn(new int[]{});

        ExamService examService = new ExamService(examRepositoryMock);
        int total = examService.findTotal();
        assertEquals(0,total);
    }
}
