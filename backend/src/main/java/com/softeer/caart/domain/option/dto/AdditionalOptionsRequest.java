package com.softeer.caart.domain.option.dto;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdditionalOptionsRequest {
	@Nullable
	private Long tagId;
	@NotNull
	private Long trimId;
	@NotNull
	private Long engineId;
	@NotNull
	private Long bodyTypeId;
	@NotNull
	private Long wdId;
	@NotNull
	private Integer offset;
	@NotNull
	private Integer pageSize;
}