import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import Testimonials from './Testimonials';

describe("Testimonials Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <Testimonials/>
            </MemoryRouter>
        );
        expect(screen.findByText("两周12-13天（主打：无旅游）：1967（营）+124（车）+2000（飞机）+200（签证）+1000（服务费及其他费用）=2.7万RMB")).not.toBeNull();
        expect(screen.findByText("注意汇率浮动")).not.toBeNull();
        expect(screen.findByText(" 一周7-8天（主打：有旅游）：926（营）+150（车）+2000（飞机）+200（签证）+300（旅游）+800（服务费及其他费用）=2.2万RMB")).not.toBeNull();

    });

});
