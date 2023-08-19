package com.softeer.caart.domain.recommendation.lifestyle.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Question;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LifestyleQuestionDto {
	private final static Integer MIN_BUDGET = 4200;
	private final static Integer MAX_BUDGET = 6900;
	private final static Integer UNIT_BUDGET = 300;

	@Getter
	public static class QuestionDto {
		private final String question;
		private final String keyword;
		private final List<AnswerDto> answers;

		public QuestionDto(Question question) {
			this.question = question.getContent();
			this.keyword = question.getKeyword();
			this.answers = question.getAnswers().stream()
				.map(AnswerDto::new)
				.collect(Collectors.toList());
		}
	}

	@Getter
	public static class BudgetQuestionDto {
		private final String question;
		private final String keyword;
		private final Integer minBudget;
		private final Integer maxBudget;
		private final Integer budgetUnit;

		public BudgetQuestionDto() {
			this.question = Question.BUDGET.getContent();
			this.keyword = Question.BUDGET.getKeyword();
			this.minBudget = MIN_BUDGET;
			this.maxBudget = MAX_BUDGET;
			this.budgetUnit = UNIT_BUDGET;
		}
	}

	@Getter
	public static class AnswerDto {
		private final String code;
		private final String answer;

		private AnswerDto(Answer answerType) {
			this.code = answerType.name();
			this.answer = answerType.getAnswer();
		}
	}
}
