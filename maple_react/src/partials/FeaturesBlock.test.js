import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import FeaturesBlocks from './FeaturesBlocks';


describe("Newsletter Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render(
            <MemoryRouter >
                <FeaturesBlocks/>
            </MemoryRouter>
        );
        expect(screen.findByText("Frequently Asked Questions")).not.toBeNull();
        expect(screen.findByText("Feel free to ask more questions by contacting us or post your question on discussion")).not.toBeNull();
        
        expect(screen.findByText("How long has Arrowhead Camp been around?")).not.toBeNull();

        expect(screen.findByText("Campers have been enjoying their summers at camp since 1972. Over the years the size and diversity of the program and facilities has grown and developed. For more info, please go to our history page.")).not.toBeNull();

        expect(screen.findByText("What is your Camper to Staff ratio")).not.toBeNull();
        expect(screen.findByText("WFor every 3 campers at camp we have 1 staff member. This ratio does not include our kitchen staff. During Junior Camp we provide a 2:1 ratio.")).not.toBeNull();

        
        expect(screen.findByText("What is the closest town?")).not.toBeNull();


        expect(screen.findByText("Arrowhead Camp is located just 5 minutes from the town of Dwight and 15 minutes from Huntsville.")).not.toBeNull();

        expect(screen.findByText("Do campers need to sign up for their daily activities?")).not.toBeNull();

        expect(screen.findByText("Short answer is no.")).not.toBeNull();

        expect(screen.findByText("Is there a Camp Nurse or Doctor?")).not.toBeNull();


        expect(screen.findByText("At Arrowhead Camp we have a dedicated group of nurses and/or health care providers who ensure excellent healthcare and support is available for the entire camp family.  Since we are so close to Huntsville, if there is need to see a doctor, we take the camper into the local drop in clinic or hospital.")).not.toBeNull();

        expect(screen.findByText("Sadly no.")).not.toBeNull();

        expect(screen.findByText("Does camp have a sky diving program?")).not.toBeNull();

    });

});