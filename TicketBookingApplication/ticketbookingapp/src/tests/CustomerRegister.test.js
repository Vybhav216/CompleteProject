import React from "react";
import { render, fireEvent, waitFor, screen } from "@testing-library/react";
import axios from "axios";
import { BrowserRouter } from "react-router-dom";
import CustomerRegister from "../pages/CustomerRegister";

jest.mock("axios");

describe("CustomerRegister", () => {
  it("renders the component correctly", () => {
    render(<BrowserRouter><CustomerRegister /></BrowserRouter>);
    
    expect(screen.getByText("User Registration Form")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("Enter first name")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("Enter last name")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("Enter your email")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("Enter your password")).toBeInTheDocument();
    expect(screen.getByText("Submit")).toBeInTheDocument();
  });
  });
