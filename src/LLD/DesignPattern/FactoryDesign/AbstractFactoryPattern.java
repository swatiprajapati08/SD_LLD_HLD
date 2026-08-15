package LLD.DesignPattern.FactoryDesign;

/*
Cloud Provider SDK ⭐⭐⭐

Product it should support
Storage
Queue
Database


Support multiple cloud providers:
Azure, AWS and GCP

 */

// Product
interface IStorage{
    void storage();
}

interface IQueue{
    void queue();
}

interface IDatabase{
    void database();
}

// Concrete product

// AWS product Implementation
class AzureStorage implements IStorage{
    @Override
    public void storage() {
        System.out.println("Azure Storage");
    }
}


class AzureQueue implements IQueue{
    @Override
    public void queue() {
        System.out.println("Azure Queue");
    }
}

class AzureDatabase implements IDatabase{
    @Override
    public void database() {
        System.out.println("Azure Database");
    }
}

// AWS product Implementation

class AwsStorage implements IStorage{

    @Override
    public void storage() {
        System.out.println("Azure Storage");
    }
}

class AwsQueue implements IQueue{
    @Override
    public void queue() {
        System.out.println("Aws Queue");
    }
}

class AwsDatabase implements IDatabase{
    @Override
    public void database() {
        System.out.println("Aws Database");
    }
}

// GCP product Implementation
class GCPStorage implements IStorage{

    @Override
    public void storage() {
        System.out.println("GCP Storage");
    }
}


class GCPQueue implements IQueue{
    @Override
    public void queue() {
        System.out.println("GCP Queue");
    }
}

class GCPDatabase implements IDatabase{
    @Override
    public void database() {
        System.out.println("GCP Database");
    }
}


// layer which is hard enforcement that all the multi-provider should have all these required product atleast

interface CloudFactory{
    IStorage storage();
    IQueue queue();
    IDatabase database();
}


class AWSFactory implements CloudFactory {
    @Override
    public IStorage storage() {
        return new AwsStorage();
    }

    @Override
    public IQueue queue() {
        return new AwsQueue();
    }

    @Override
    public IDatabase database() {
        return new AwsDatabase();
    }
}

class AzureFactory implements CloudFactory {
    @Override
    public IStorage storage() {
        return new AzureStorage();
    }

    @Override
    public IQueue queue() {
        return new AzureQueue();
    }

    @Override
    public IDatabase database() {
        return new AzureDatabase();
    }
}

class GCPFactory implements CloudFactory {
    @Override
    public IStorage storage() {
        return new GCPStorage();
    }

    @Override
    public IQueue queue() {
        return new GCPQueue();
    }

    @Override
    public IDatabase database() {
        return new GCPDatabase();
    }
}

class CloudProvider{
    IStorage iStorage;
    IQueue iQueue;
    IDatabase iDatabase;

    CloudProvider(CloudFactory factory){
        iStorage = factory.storage();
        iQueue = factory.queue();
        iDatabase = factory.database();

        showAll();
    }
    void showAll(){
        iStorage.storage();
        iQueue.queue();
        iDatabase.database();
    }


    void changeFactory(CloudFactory factory){
        iStorage = factory.storage();
        iQueue = factory.queue();
        iDatabase = factory.database();
        showAll();
    }
}



public class AbstractFactoryPattern {

    public static void main(String[] args) {
        // client will only care about product and will

        CloudProvider provider = new CloudProvider(new AzureFactory());
        provider.changeFactory(new GCPFactory());

        System.out.println("ISP followed");
        System.out.println("QUEUE supported");
        QueueSupportedCloudProviderISP providerISP = new QueueSupportedCloudProviderISP(new AWSFactoryISP(),new AWSFactoryISP(),new
                AWSFactoryISP());
        providerISP.getQueue().queue();

        System.out.println("NOT QUEUE supported");
        CloudProviderISP cloudProviderISP = new CloudProviderISP(new GCPFactoryISP(),new GCPFactoryISP());
        cloudProviderISP.getStorage().storage();
    }
}

/*
 Extras
 --> If GCP Cloud doesn't support queues, how would you redesign this while still using the Abstract Factory pattern?

  Currently, CloudFactory assume all the product will have all 3 product
  interface CloudFactory{
    IStorage storage();
    IQueue queue();
    IDatabase database();
}

 if Oracle will come it have to implement queue even if it is not supported
 Violated the Interface Segregation Principle.
 Clients should not be forced to depend on interfaces they do not use.

Segregate the interfaces
instead of CloudFactory seperate it out
 */

interface StorageFactory {
    IStorage createStorage();
}

interface QueueFactory {
    IQueue createQueue();
}

interface DatabaseFactory {
    IDatabase createDatabase();
}


class AWSFactoryISP implements StorageFactory,QueueFactory,DatabaseFactory{
    @Override
    public IDatabase createDatabase() {
        return new AwsDatabase();
    }

    @Override
    public IQueue createQueue() {
        return new AwsQueue();
    }

    @Override
    public IStorage createStorage() {
        return new AwsStorage();
    }
}


class GCPFactoryISP implements StorageFactory,DatabaseFactory{

    @Override
    public IDatabase createDatabase() {
        return new GCPDatabase();
    }

    @Override
    public IStorage createStorage() {
        return new GCPStorage();
    }
}


class CloudProviderISP {
 IStorage iStorage;
 IDatabase iDatabase;

 CloudProviderISP(StorageFactory storageFactory,DatabaseFactory databaseFactory){
     this.iDatabase = databaseFactory.createDatabase();
     this.iStorage = storageFactory.createStorage();
 }

    public IStorage getStorage() {
        return iStorage;
    }

    public IDatabase getDatabase() {
        return iDatabase;
    }
}

// for QUEUE

class QueueSupportedCloudProviderISP extends CloudProviderISP{
    IQueue iQueue;

    QueueSupportedCloudProviderISP(StorageFactory storageFactory, DatabaseFactory databaseFactory,QueueFactory queueFactory) {
        super(storageFactory, databaseFactory);
        this.iQueue = queueFactory.createQueue();
    }

    public IQueue getQueue() {
        return iQueue;
    }
}