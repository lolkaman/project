/*
 * This file is generated by jOOQ.
 */
package domain.jooq.tables.records;


import domain.jooq.tables.Links;

import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LinksRecord extends UpdatableRecordImpl<LinksRecord> implements Record3<Long, Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>LINKS.ID</code>.
     */
    public void setId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>LINKS.ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>LINKS.CHAT_ID</code>.
     */
    public void setChatId(@NotNull Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>LINKS.CHAT_ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getChatId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>LINKS.LINK_URL</code>.
     */
    public void setLinkUrl(@NotNull String value) {
        set(2, value);
    }

    /**
     * Getter for <code>LINKS.LINK_URL</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 255)
    @NotNull
    public String getLinkUrl() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row3<Long, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return Links.LINKS.ID;
    }

    @Override
    @NotNull
    public Field<Long> field2() {
        return Links.LINKS.CHAT_ID;
    }

    @Override
    @NotNull
    public Field<String> field3() {
        return Links.LINKS.LINK_URL;
    }

    @Override
    @NotNull
    public Long component1() {
        return getId();
    }

    @Override
    @NotNull
    public Long component2() {
        return getChatId();
    }

    @Override
    @NotNull
    public String component3() {
        return getLinkUrl();
    }

    @Override
    @NotNull
    public Long value1() {
        return getId();
    }

    @Override
    @NotNull
    public Long value2() {
        return getChatId();
    }

    @Override
    @NotNull
    public String value3() {
        return getLinkUrl();
    }

    @Override
    @NotNull
    public LinksRecord value1(@NotNull Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public LinksRecord value2(@NotNull Long value) {
        setChatId(value);
        return this;
    }

    @Override
    @NotNull
    public LinksRecord value3(@NotNull String value) {
        setLinkUrl(value);
        return this;
    }

    @Override
    @NotNull
    public LinksRecord values(@NotNull Long value1, @NotNull Long value2, @NotNull String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LinksRecord
     */
    public LinksRecord() {
        super(Links.LINKS);
    }

    /**
     * Create a detached, initialised LinksRecord
     */
    @ConstructorProperties({ "id", "chatId", "linkUrl" })
    public LinksRecord(@NotNull Long id, @NotNull Long chatId, @NotNull String linkUrl) {
        super(Links.LINKS);

        setId(id);
        setChatId(chatId);
        setLinkUrl(linkUrl);
    }

    /**
     * Create a detached, initialised LinksRecord
     */
    public LinksRecord(domain.jooq.tables.pojos.Links value) {
        super(Links.LINKS);

        if (value != null) {
            setId(value.getId());
            setChatId(value.getChatId());
            setLinkUrl(value.getLinkUrl());
        }
    }
}
