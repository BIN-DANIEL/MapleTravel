import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import SignUp from './SignUp';


describe("Newsletter Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <SignUp/>
            </MemoryRouter>
        );
        // expect(screen.findByText("Frequently Asked Questions")).not.toBeNull();
        // expect(screen.findByText("Feel free to ask more questions by contacting us or post your question on discussion")).not.toBeNull();



        expect(screen.findByText("Welcome")).not.toBeNull();

        expect(screen.findByText("terms & conditions")).not.toBeNull();


        expect(screen.findByText("Password")).not.toBeNull();

        expect(screen.findByText("Re-enter Password")).not.toBeNull();

        expect(screen.findByText("Sign up")).not.toBeNull();

        expect(screen.findByText("By creating an account, you agree to the")).not.toBeNull();

        expect(screen.findByText("Already using Maple Travel?")).not.toBeNull();

    });

});