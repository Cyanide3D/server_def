package com.defiant.server.controller;

import com.defiant.server.dto.WireDto;
import com.defiant.server.model.User;
import com.defiant.server.service.WireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wire")
public class WireController {

    @Autowired
    private WireService wireService;

    @PostMapping
    public void wire(@AuthenticationPrincipal User user, @RequestBody WireDto dto) {
        wireService.wire(dto, user);
    }

}
