package com.bcp.democosmosdb.core.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.bcp.democosmosdb.core.documents.StudentDocument;

public interface StudentRepository extends CosmosRepository<StudentDocument,String> {

}
