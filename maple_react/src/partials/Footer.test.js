import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import Footer from './Footer';


describe("Footer Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <Footer/>
            </MemoryRouter>
        );
        expect(screen.findByText("Products")).not.toBeNull();
        expect(screen.findByText("Get the latest news and articles to your inbox every month.")).not.toBeNull();
        expect(screen.findByText("Subscribe")).not.toBeNull();

        expect(screen.findByText("Home")).not.toBeNull();

        expect(screen.findByText("About us")).not.toBeNull();
        expect(screen.findByText("Company values")).not.toBeNull();
        expect(screen.findByText("Pricing")).not.toBeNull();
        expect(screen.findByText("Privacy Policy")).not.toBeNull();

        expect(screen.findByText("Email")).not.toBeNull();

        expect(screen.findByText("Cruip")).not.toBeNull();

        expect(
            container.querySelector(
                '#produtlink'
            ).children[0].children[0].textContent
        ).toBe("Web Studio");

        expect(
            container.querySelector(
                '#produtlink'
            ).children[1].children[0].textContent
        ).toBe("DynamicBox Flex");

        expect(
            container.querySelector(
                '#produtlink'
            ).children[2].children[0].textContent
        ).toBe("Programming Forms");


    });

});