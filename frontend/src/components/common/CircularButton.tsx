import React from 'react';
import styled from 'styled-components';
import { checkButtonOption } from './CheckButton';

function CircularButton({ selected }: checkButtonOption) {
  return selected ? (
    <Button selected>
      <FlexBox>
        <img src="/images/white-lg-check-icon.svg" width={16} height={16} />
        <span className="caption-medium-12 text-grey-1000">선택</span>
      </FlexBox>
    </Button>
  ) : (
    <Button>
      <FlexBox>
        <img src="/images/blue-lg-check-icon.svg" width={16} height={16} />
        <span className="caption-medium-12 text-primary-blue">선택</span>
      </FlexBox>
    </Button>
  );
}

export default CircularButton;

const Button = styled.button<checkButtonOption>`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 69px;
  height: 28px;
  background-color: ${props =>
    props.selected ? `var(--primary-blue)` : `var(--grey-1000)`};
  border: ${props => !props.selected && `1px solid var(--primary-blue)`};
  border-radius: 20px;
  padding-top: 1px;
`;

const FlexBox = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 8px;
`;