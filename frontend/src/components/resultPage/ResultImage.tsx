import React from 'react';
import { styled } from 'styled-components';

function ResultImage() {
  return (
    <Wrapper>
      <ImageTop src="/images/temp_top_image.png" />
      <DownloadIcon>
        <img src="/images/download_icon.svg" />
      </DownloadIcon>
      <ShadeTop src="/images/triangle.svg" />
      <ImageBottom>
        <Flex>
          <span className="text-grey-300 body-medium-14">펠리세이드</span>
          <Logo src="/images/hyundai_logo_default.svg" />
        </Flex>
        <span className="text-grey-0 head-medium-16">Le Blanc(르블랑)</span>
        <Shade src="/images/triangle.svg" />
      </ImageBottom>
    </Wrapper>
  );
}

export default ResultImage;

const ImageTop = styled.img`
  width: 320px;
  height: 199px;
  flex-shrink: 0;
  border-radius: 0px 8px 0px 0px;
`;

const ImageBottom = styled.div`
  position: relative;
  width: 320px;
  height: 76px;
  flex-shrink: 0;
  border-radius: 0px 0px 0px 8px;
  border-top: 1px solid var(--grey-700);
  background: var(--grey-1000);
  padding: 12px 16px 18px 16px;
  margin-top: -3px;
`;

const Flex = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Logo = styled.img`
  width: 70px;
  height: 10px;
  flex-shrink: 0;
`;

const Wrapper = styled.div`
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
`;

const Shade = styled.img`
  position: absolute;
  bottom: -30px;
  right: -27px;
  width: 98px;
  height: 88px;
`;

const ShadeTop = styled.img`
  transform: rotate(180deg);
  position: absolute;
  top: -27px;
  left: -8px;
  width: 98px;
  height: 88px;
`;

const DownloadIcon = styled.div`
  position: absolute;
  top: 16px;
  right: 16px;
  cursor: pointer;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: rgba(255, 255, 255, 0.5);
  z-index: 3;
  display: flex;
  align-items: center;
  justify-content: center;
`;