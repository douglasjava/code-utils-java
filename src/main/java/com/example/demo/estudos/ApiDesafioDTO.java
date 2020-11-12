package com.example.demo.estudos;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiDesafioDTO {

	private Integer page;
	private Integer per_page;
	private Integer total;
	private Integer total_pages;
	private List<Data> data;

}
