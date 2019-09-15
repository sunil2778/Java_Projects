package com.lendico.repayment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.repayment.model.Repayment;
import com.lendico.repayment.model.RepaymentInput;
import com.lendico.repayment.service.RePayMentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "RepayController", description = "REST Apis related to Repayment!!!!")
@RestController
@RequestMapping(path = "/generate-plan")
public class RepayController {

	@Autowired

	private RePayMentService repayservice;

	@ApiOperation(value = "pre-calculated repayment plans throughout the lifetime of a loan. ", response = Iterable.class, tags = "getRePayment")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")

	public List<Repayment> getRePayment(@Valid @RequestBody RepaymentInput input) {

		return repayservice.getRepayments(input);
	}

}
