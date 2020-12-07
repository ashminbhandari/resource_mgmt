package com.itlize.resrcmgmt.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="column_added_row_value")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ColumnAddedRowValue {
    @Id
    @GeneratedValue
    private Integer column_added_row_value_id;

    @ManyToOne
    @JoinColumn(name="column_added_name")
    private ColumnAdded column_added_name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="resource_id")
    private Resource resource_id;

    private String row_value;
}
