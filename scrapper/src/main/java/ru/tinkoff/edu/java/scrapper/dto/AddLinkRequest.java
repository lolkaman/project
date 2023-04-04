package ru.tinkoff.edu.java.scrapper.dto;

import jakarta.validation.constraints.NotNull;

import java.net.URI;

public record AddLinkRequest(@NotNull URI link) {
}
