package com.pet.shop.pojo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    public Integer id;

    public String username;

    public String pwd;

    public String phone;

    public Integer identity;

    public String address;
}
