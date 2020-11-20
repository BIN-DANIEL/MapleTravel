import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import SignIn from './SignIn';



describe("FeatureBlock Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <SignIn/>
            </MemoryRouter>
        );
        expect(screen.findByText("Welcome back.")).not.toBeNull();
        expect(screen.findByText("Having trouble signing in?")).not.toBeNull();

        expect(screen.findByText("Keep me signed in")).not.toBeNull();

        expect(screen.findByText("Having trouble signing in?")).not.toBeNull();

        expect(screen.findByText("Don’t you have an account?")).not.toBeNull();
        expect(screen.findByText("Sign up")).not.toBeNull();

    });

});