package core.basesyntax.hadler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class IncreaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public IncreaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int storageQuantity = storageDao.getQuantity(transaction.getFruit());
        storageDao.save(transaction.getFruit(),
                storageQuantity + transaction.getQuantity());
    }
}