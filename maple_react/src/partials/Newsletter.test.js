import React from "react";
import {
    MemoryRouter
} from "react-router-dom";
import {
    render,
    screen
} from '@testing-library/react';
import Newsletter from './Newsletter';


describe("Newsletter Test Case", () => {
    it("Text Showing Correctly", () => {
        const {
            container
        } = render( <
            MemoryRouter >
            <
            Newsletter / >
            <
            /MemoryRouter>
        );
        expect(screen.findByText("Discover the Place")).not.toBeNull();
        expect(screen.findByText("可俯瞰美丽清澈的海湾湖")).not.toBeNull();

        expect(
            screen.findAllByText("营地很容易开车到达，因此他们鼓励首次露营者的父母在允许的情况下尽可能自驾将孩子送到营地，让他们有机会看到自己孩子的在营状况及工作人员的情况。 营地提供接送巴士（单程或回程），如需要相关服务的话可以与Arrowhead counselors联系，渥太华和多伦多都有发车点，需额外收费。")
        ).not.toBeNull();

        expect(
            screen.findAllByText("Arrowhead Camp占地26英亩，可俯瞰美丽清澈的海湾湖。营地距多伦多240公里，距渥太华320公里，位于风景如画的马斯科卡、阿尔冈金公园和亨茨维尔之间。")
        ).not.toBeNull();

        expect(
            screen.findAllByText("因此他们鼓励首次露营者的父母在允许的情况下尽可能自驾将孩子送到营地")
        ).not.toBeNull();

        expect(
            screen.findAllByText("距渥太华320公里，位于风景如画的马斯科卡")
        ).not.toBeNull();

        expect(
            container.querySelector(
                '#newsletter'
            ).children[0].children[0].children[0].children[0].children[0].src.includes("Picture2.jpg")
        ).toBe(true);

        expect(
            container.querySelector(
                '#newsletter'
            ).children[0].children[0].children[0].children[1].children[0].children[0].textContent
        ).toBe("Discover the Place");

        expect(
            container.querySelector(
                '#newsletter'
            ).children[0].children[0].children[0].children[1].children[0].children[1].textContent.includes("营地距多伦多240公里，距渥太华320公里")
        ).toBe(true);

        expect(
            container.querySelector(
                '#newsletter'
            ).children[0].children[0].children[0].children[1].children[0].children[2].children[0].textContent.includes("因此他们鼓励首次露营者的父母在允许的情况下尽可能自驾将孩子送到营地")
        ).toBe(true);
    });

});