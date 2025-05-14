package com.hiringapp.controller;

import com.hiringapp.model.entity.BankInfo;
import com.hiringapp.service.BankInfoService;
import com.hiringapp.utils.dtos.BankInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
@Slf4j
public class BankInfoController {

    @Autowired
    private BankInfoService bankInfoService;

    @PostMapping("/upload-bank_info")
    public ResponseEntity<BankInfoDTO> uploadBankInfo(@RequestBody final BankInfoDTO bankInfoDTO) {
        return new ResponseEntity<>(bankInfoService.saveBankInfo(bankInfoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankInfoDTO> getBankInfo(@PathVariable Long id) {
        return new ResponseEntity<>(bankInfoService.getBankInfoById(id), HttpStatus.OK);
    }
}