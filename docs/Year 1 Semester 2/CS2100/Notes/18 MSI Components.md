# MSI Components

## Introduction

MIS: Medium scale integration

**Four Common and useful MSI circuits:**

- Decode
- Demultiplexer
- Encoder
- Multiplexer

Visit [[Lect18_MSI_Components_full.pdf#page=3]]
## Decoder

- Codes are frequently used to represent entities, eg: your name is a code to denote yourself (an entity!)
- These codes can be identified (or decoded) using a decoder. Given a code, identify the entity.
- Convert binary information from $n$ input lines to (a maximum of) $2^n$ output lines.
- Known as $n$-to- $m$-line decoder, or simply $n: m$ or $n \times m$ decoder $\left(m \leq 2^n\right)$.
- May be used to generate $2^n$ minterms of $n$ input variables.

Visit [[Lect18_MSI_Components_full.pdf#page=7]] 

### Using Decoder to implement Full adder

Visit [[Lect18_MSI_Components_full.pdf#page=13]] 

## Decoder with Enable

Decoders often come with an enable control signal, so that the device is only activated when the enable, $E=1$.

In most MSI decoders, enable signal is zero-enable, usually denoted by $\mathrm{E}^{\prime}$ or $\bar{E}$. The decoder is enabled when the signal is zero (low).

Visit [[Lect18_MSI_Components_full.pdf#page=15]] 

## Constructing Larger Decoders

Visit [[Lect18_MSI_Components_full.pdf#page=17]] 

## Standard MSI Decoder

Has negated output!

Visit [[Lect18_MSI_Components_full.pdf#page=21]] 

## Implementing Functions 

Visit [[Lect18_MSI_Components_full.pdf#page=23]]

## Encoders

Visit [[Lect18_MSI_Components_full.pdf#page=26]]

## Priority Encoder

A priority encoder is one with priority

- If two or more inputs or equal to 1 , the input with the highest priority takes precedence.
- If all inputs are 0, this input combination is considered invalid.

Visit [[Lect18_MSI_Components_full.pdf#page=32]]

## Multiplexers and Demultiplexers

Visit [[Lect18_MSI_Components_full.pdf#page=34]]

## Demultiplexers

- It turns out that the demultiplexer circuit is actually identical to a decoder with enable.

Visit [[Lect18_MSI_Components_full.pdf#page=35]]
## Multiplexers

Visit [[Lect18_MSI_Components_full.pdf#page=37]]

## Multiplexer IC Package

Visit [[Lect18_MSI_Components_full.pdf#page=37]]

## Constructing Larger Multiplexers

Visit [[Lect18_MSI_Components_full.pdf#page=42]]

## Standard MSI Multiplexer

w is just the complement of y

Visit [[Lect18_MSI_Components_full.pdf#page=46]]

## Implementing Functions using Multiplexers

Visit [[Lect18_MSI_Components_full.pdf#page=48]]

## Using Smaller Multiplexers

- Earlier, we saw how a $2^n$-to-1 multiplexer can be used to implement a Boolean function of $n$ (input) variables.
- However, we can use a single smaller $2^{(n-1)}$-to-1 multiplexer to implement a Boolean function of $n$ (input) variables.

Visit [[Lect18_MSI_Components_full.pdf#page=51]]

[[Lect18_MSI_Components_full.pdf#page=54|Here]], the grouping is done by A and B. eg A = 0, B = 0 is grouped together. A = 0, B = 1 is grouped together. See [[CS2100_tut08qns.pdf\|tut08 Q1]] for example. 

Choose the Most significant bit for selectors because they are easily grouped together.