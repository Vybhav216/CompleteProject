import React from "react";
import { render, screen, waitFor } from "@testing-library/react";
import axios from "axios";
import CustomersList from "../pages/CustomerList";
 
jest.mock("axios");
 
describe("CustomersList", () => {
  test("renders customers list correctly", async () => {
    const mockData = [
      { userId: 1, userName: "John", email: "john@example.com", active: true },
      { userId: 2, userName: "Jane", email: "jane@example.com", active: false },
    ];
 
    axios.get.mockResolvedValueOnce({ data: mockData });
 
    render(<CustomersList />);
 
    // Wait for the data to be loaded
    await waitFor(() => {
      expect(screen.getByText("Users List")).toBeInTheDocument();
      expect(screen.getByText("John")).toBeInTheDocument();
      expect(screen.getByText("jane@example.com")).toBeInTheDocument();
    });
  });
 
  test("filters out admin users", async () => {
    const mockData = [
      { userId: 1, userName: "John", email: "john@example.com", active: true, admin: true },
      { userId: 2, userName: "Jane", email: "jane@example.com", active: false, admin: false },
    ];
 
    axios.get.mockResolvedValueOnce({ data: mockData });
 
    render(<CustomersList />);
 
    // Wait for the data to be loaded
    await waitFor(() => {
      // Ensure that the admin user is not in the rendered table
      expect(screen.queryByText("John")).not.toBeInTheDocument();
      // Ensure that the non-admin user is in the rendered table
      expect(screen.getByText("Jane")).toBeInTheDocument();
    });
  });
});
 