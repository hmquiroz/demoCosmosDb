package com.bcp.democosmosdb.core.service.impl;

import com.azure.cosmos.implementation.NotFoundException;
import com.bcp.democosmosdb.core.documents.AddressDocument;
import com.bcp.democosmosdb.core.documents.StudentDocument;
import com.bcp.democosmosdb.core.dto.AddressDto;
import com.bcp.democosmosdb.core.dto.StudentDto;
import com.bcp.democosmosdb.core.exception.StudentNotFoundException;
import com.bcp.democosmosdb.core.repository.StudentRepository;
import com.bcp.democosmosdb.core.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentDto dto) {
        StudentDocument studentDocument = new StudentDocument();
        BeanUtils.copyProperties(dto, studentDocument);
        AddressDocument addressDocument = new AddressDocument();
        addressDocument.setDistrict(dto.getAddress().getDistrict());
        addressDocument.setNumber(dto.getAddress().getNumber());
        addressDocument.setStreet(dto.getAddress().getStreet());
        studentDocument.setAddress(addressDocument);
        studentRepository.save(studentDocument);
    }

    @Override
    @Transactional
    public void deleteStudent(StudentDto dto) {
        StudentDocument studentDocument = new StudentDocument();
        BeanUtils.copyProperties(dto, studentDocument);
        AddressDocument addressDocument = new AddressDocument();
        if(dto.getAddress()!=null){
            addressDocument.setDistrict(dto.getAddress().getDistrict());
            addressDocument.setStreet(dto.getAddress().getStreet());
            addressDocument.setNumber(dto.getAddress().getNumber());
            studentDocument.setAddress(addressDocument);
        }
        studentRepository.delete(studentDocument);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findAll().forEach(document->{
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(document,studentDto);
            if(document.getAddress()!=null){
                AddressDto addressDto = new AddressDto();
                addressDto.setDistrict(document.getAddress().getDistrict());
                addressDto.setStreet(document.getAddress().getStreet());
                addressDto.setNumber(document.getAddress().getNumber());
                studentDto.setAddress(addressDto);
            }
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }

    @Override
    public StudentDto getStudent(String id) {
        StudentDto studentDto = new StudentDto();
        //StudentDocument document = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        StudentDocument document = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        BeanUtils.copyProperties(document,studentDto);
        if(document.getAddress()!=null){
            AddressDto addressDto = new AddressDto();
            addressDto.setDistrict(document.getAddress().getDistrict());
            addressDto.setStreet(document.getAddress().getStreet());
            addressDto.setNumber(document.getAddress().getNumber());
            studentDto.setAddress(addressDto);
        }
        return studentDto;
    }
}
