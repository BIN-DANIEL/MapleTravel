import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import ResetPassword from './ResetPassword';


describe("ResetPassword Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <ResetPassword/>
            </MemoryRouter>
        );
        expect(screen.findByText("Let’s get you back up on your feet")).not.toBeNull();

        expect(screen.findByText("Enter the email address you used when you signed up for your account, and we’ll email you a link to reset your password.")).not.toBeNull();

        expect(screen.findByText("Send reset link")).not.toBeNull();

        expect(screen.findByText("Email")).not.toBeNull();

    });

});