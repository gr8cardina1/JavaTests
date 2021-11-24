package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_entity")
public class ServiceEntity {
    @Id
    private Integer customerId;
    private String externalId;
    private String createdAt;

    public ServiceEntity() {
    }

    public ServiceEntity(Integer customerId, String externalId, String createdAt) {
        this.customerId = customerId;
        this.externalId = externalId;
        this.createdAt = createdAt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
