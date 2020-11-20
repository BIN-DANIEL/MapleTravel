import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import Header from './Header';

describe("Header Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <Header/>
            </MemoryRouter>
        );
        expect(screen.findByText("Maple travel & Learn +")).not.toBeNull();

        expect(
            container.querySelector(
                '#cllinks'
            ).children[0].textContent
        ).toBe("Class Room");

        expect(
            container.querySelector(
                '#silinks'
            ).children[0].textContent
        ).toBe("Sign in");

        expect(
            container.querySelector(
                '#sulinks'
            ).children[0].textContent
        ).toBe("Sign up");


     });



});