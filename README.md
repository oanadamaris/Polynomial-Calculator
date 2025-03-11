# 🧮 Polynomial Calculator  

A GUI-based calculator for performing arithmetic and calculus operations on polynomials, designed for accuracy and user-friendly interaction.  

---

## 📖 Table of Contents  
- [📌 Description](#-description)  
  - [💛 Motivation](#-motivation)  
  - [🎯 Why this project?](#-why-this-project)  
  - [✅ What problem does it solve?](#-what-problem-does-it-solve)  
  - [💡 What I learned](#-what-i-learned)  
- [🚀 Usage](#-usage)  
  - [📥 Input Format](#-input-format)  
  - [🎛️ Operations](#%EF%B8%8F-operations)  
  - [🖼️ Interface Preview](#%EF%B8%8F-interface-preview)  
- [✨ Features](#-features)  
- [🛠️ Built With](#-built-with)  

---

## 📌 Description  

This project simplifies polynomial calculations by providing an intuitive interface for arithmetic operations (addition, subtraction, etc.) and calculus operations (derivatives, integrals).  

### 💛 Motivation  
Polynomials are fundamental in mathematics and engineering, but manual calculations are error-prone. This tool automates the process, ensuring precision and efficiency.  

### 🎯 Why this project?  
I wanted to explore GUI development, input validation, and complex algorithm design while creating a practical tool.  

### ✅ What problem does it solve?  
It eliminates manual errors in polynomial operations and speeds up computations for complex expressions.  

### 💡 What I learned  
- How to use **Java Swing** to build responsive GUIs  
- How to create **Regex** expressions for validating polynomial inputs  
- How to implement **data structures** like `HashMap` to store and manipulate polynomials  
- How to apply **JUnit** for testing mathematical logic

---

## 🚀 Usage  

### 📥 Input Format  
Enter polynomials in standard form (e.g., `3x^2 - 2x + 5`).  
**Example Inputs**:  
- Polynomial 1: `2x^3 + 4x`  
- Polynomial 2: `x^2 - 1`  

### 🎛️ Operations  
1. **Arithmetic**:  
   - Click buttons for **Add**, **Subtract**, **Multiply**, or **Divide**.  
2. **Calculus**:  
   - Use **Derive** or **Integrate** buttons for single-polynomial operations (the operation will be applied to the first polynomial).   

### 🖼️ Demo  

<img width="300" src="https://github.com/user-attachments/assets/f39b366e-6a01-4a98-9630-0a896bfcb9f2" />  

---

## ✨ Features  
✅ **Six Operations**  
- Arithmetic: Add, Substract, Multiply, Divide
  
<p align="center">
  <img width="400" alt="Add" src="https://github.com/user-attachments/assets/04f08a58-65f6-4db8-93af-77722cd648f7" />
  <img width="400" alt="Sub" src="https://github.com/user-attachments/assets/e4893deb-57eb-4171-b30c-4446811ba214" />
  <img width="400" alt="Mult" src="https://github.com/user-attachments/assets/86ff9edd-c3fe-43de-9ee2-3ed606b6cf84" />
  <img width="400" alt="Div" src="https://github.com/user-attachments/assets/115887dc-e593-49aa-8e0c-f9ab57ce461c" />
</p>

- Calculus: Derive, Integrate

  <p align="center">
  <img width="400" alt="Derivat" src="https://github.com/user-attachments/assets/422ceb81-a6d2-4ee5-8000-aed7381538d1" />
  <img width="400" alt="Integrate" src="https://github.com/user-attachments/assets/cef2a907-57d5-455c-952f-5dab23ad99df" />
</p>

✅ **Efficient Data Handling**  
- `HashMap` stores monomials for fast exponent-coefficient mapping.  
- Results are sorted by descending exponents for clarity.  

✅ **Input Validation**  
- Regex ensures only valid polynomials (e.g., `x`, `-3x^2`, `5`) are accepted.  


---

## 🛠️ Built With  
| Technology  | Description                     |  
|-------------|---------------------------------|  
| **Java**    | Core programming language       |  
| **Swing**   | GUI framework                   |  
| **JUnit**   | Testing framework               |  
| **Regex**   | Input validation                |  
