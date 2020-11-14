import React from "react";
import { MemoryRouter } from "react-router-dom";
import { render, screen} from '@testing-library/react';
import HeroHome from './HeroHome';


describe("School Camp Test Case", () => {
    it("Text Showing Correctly", () => {
        const { container } =  render(
        <MemoryRouter>
          <HeroHome/>
        </MemoryRouter>
      );
      expect(screen.findByText("Arrowed")).not.toBeNull();
      expect(screen.findByText("Camp")).not.toBeNull();

      expect(
        screen.findAllByText("相信营地体验能给每一位孩子带来影响深远的宝贵经验，他们的目标是为每一位露营者提供尽可能最好的机会来促进他们在一个欢快的环境中学习和成长")
      ).not.toBeNull();

      expect(
        screen.findAllByText("Rates")
      ).not.toBeNull();



      expect(
        container.querySelector(
          '[class = "relative"]'
        ).children[1].children[0].children[0].children[0].textContent
      ).toBe("ArrowHead Camp");
});

});