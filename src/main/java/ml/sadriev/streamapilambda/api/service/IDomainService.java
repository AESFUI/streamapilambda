package ml.sadriev.streamapilambda.api.service;

import ml.sadriev.streamapilambda.model.Domain;

/**
 * @author Andrey Sadriev
 */
public interface IDomainService {

    void load(Domain domain);

    void export(Domain domain);
}
