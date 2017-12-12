package org.bcos.evidence.web3j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.web3j.abi.EventEncoder;
import org.bcos.web3j.abi.EventValues;
import org.bcos.web3j.abi.FunctionEncoder;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Bool;
import org.bcos.web3j.abi.datatypes.DynamicArray;
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.bcos.web3j.protocol.core.methods.request.EthFilter;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.2.1.
 */
public final class EvidenceSignersData extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b604051612b7d380380612b7d833981016040528080518201919050505b60008090505b81518110156100c2576000805480600101828161004f91906100ca565b916000526020600020900160005b848481518110151561006b57fe5b90602001906020020151909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b806001019050610032565b5b505061011b565b8154818355818115116100f1578183600052602060002091820191016100f091906100f6565b5b505050565b61011891905b808211156101145760008160009055506001016100fc565b5090565b90565b612a538061012a6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633ffefe4e146200006f57806363a9c3d714620000d557806394cf795e1462000129578063a42862641462000199578063fa69efbd14620002e5575b600080fd5b34156200007b57600080fd5b62000093600480803590602001909190505062000311565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3415620000e157600080fd5b6200010f600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506200037b565b604051808215151515815260200191505060405180910390f35b34156200013557600080fd5b6200013f62000424565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015620001855780820151818401525b60208101905062000167565b505050509050019250505060405180910390f35b3415620001a557600080fd5b620002a3600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803560ff169060200190919080356000191690602001909190803560001916906020019091905050620004bd565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3415620002f157600080fd5b620002fb62000741565b6040518082815260200191505060405180910390f35b6000806000805490509050808310156200036a576000838154811015156200033557fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16915062000375565b6000915062000375565b5b50919050565b600080600090505b6000805490508110156200041957600081815481101515620003a157fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614156200040c57600191506200041e565b5b80600101905062000383565b600091505b50919050565b6200042e6200074e565b6000805480602002602001604051908101604052809291908181526020018280548015620004b257602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831162000467575b505050505090505b90565b6000808787878787873033620004d262000762565b808060200180602001806020018960ff1660ff168152602001886000191660001916815260200187600019166000191681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528c818151815260200191508051906020019080838360005b83811015620005a65780820151818401525b60208101905062000588565b50505050905090810190601f168015620005d45780820380516001836020036101000a031916815260200191505b5084810383528b818151815260200191508051906020019080838360005b83811015620006105780820151818401525b602081019050620005f2565b50505050905090810190601f1680156200063e5780820380516001836020036101000a031916815260200191505b5084810382528a818151815260200191508051906020019080838360005b838110156200067a5780820151818401525b6020810190506200065c565b50505050905090810190601f168015620006a85780820380516001836020036101000a031916815260200191505b509b505050505050505050505050604051809103906000f0801515620006cd57600080fd5b90507f8b94c7f6b3fadc764673ea85b4bfef3e17ce928d13e51b818ddfa891ad0f1fcc81604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a18091505b509695505050505050565b6000808054905090505b90565b602060405190810160405280600081525090565b6040516122b48062000774833901905600606060405234156200001057600080fd5b604051620022b4380380620022b4833981016040528080518201919060200180518201919060200180518201919060200180519060200190919080519060200190919080519060200190919080519060200190919080519060200190919050505b81600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550620000d1816200061164010000000002620017f3176401000000009004565b156200041d578760009080519060200190620000ef929190620006fd565b50866001908051906020019062000108929190620006fd565b50856002908051906020019062000121929190620006fd565b506003805480600101828162000138919062000784565b91600052602060002090602091828204019190065b87909190916101000a81548160ff021916908360ff16021790555050600480548060010182816200017f9190620007c1565b916000526020600020900160005b869091909150906000191690555060058054806001018281620001b19190620007c1565b916000526020600020900160005b859091909150906000191690555060068054806001018281620001e39190620007f0565b916000526020600020900160005b83909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f6001b9d5afd61e6053e8a73e30790ef8240d919a754055049131521927fbe21188888888888888604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b818151815260200191508051906020019080838360005b83811015620003005780820151818401525b602081019050620002e2565b50505050905090810190601f1680156200032e5780820380516001836020036101000a031916815260200191505b5084810383528a818151815260200191508051906020019080838360005b838110156200036a5780820151818401525b6020810190506200034c565b50505050905090810190601f168015620003985780820380516001836020036101000a031916815260200191505b50848103825289818151815260200191508051906020019080838360005b83811015620003d45780820151818401525b602081019050620003b6565b50505050905090810190601f168015620004025780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390a162000602565b7f45cb885dcdccd3bece3cb78b963aec501f1cf9756fd93584f0643c7a9533431088888888888888604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b818151815260200191508051906020019080838360005b83811015620004ea5780820151818401525b602081019050620004cc565b50505050905090810190601f168015620005185780820380516001836020036101000a031916815260200191505b5084810383528a818151815260200191508051906020019080838360005b83811015620005545780820151818401525b60208101905062000536565b50505050905090810190601f168015620005825780820380516001836020036101000a031916815260200191505b50848103825289818151815260200191508051906020019080838360005b83811015620005be5780820151818401525b602081019050620005a0565b50505050905090810190601f168015620005ec5780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390a15b5b50505050505050506200086f565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166363a9c3d7836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515620006d957600080fd5b6102c65a03f11515620006eb57600080fd5b5050506040518051905090505b919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200074057805160ff191683800117855562000771565b8280016001018555821562000771579182015b828111156200077057825182559160200191906001019062000753565b5b5090506200078091906200081f565b5090565b815481835581811511620007bc57601f016020900481601f01602090048360005260206000209182019101620007bb91906200081f565b5b505050565b815481835581811511620007eb57818360005260206000209182019101620007ea919062000847565b5b505050565b8154818355818115116200081a578183600052602060002091820191016200081991906200081f565b5b505050565b6200084491905b808211156200084057600081600090555060010162000826565b5090565b90565b6200086c91905b80821115620008685760008160009055506001016200084e565b5090565b90565b611a35806200087f6000396000f30060606040523615610076576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633b52ebd01461007b57806348f85bce146100d0578063596f21f81461012857806394cf795e146103b5578063c7eaf9b414610420578063dc58ab11146104af575b600080fd5b341561008657600080fd5b61008e610500565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156100db57600080fd5b61010e600480803560ff169060200190919080356000191690602001909190803560001916906020019091905050610526565b604051808215151515815260200191505060405180910390f35b341561013357600080fd5b61013b610ffc565b604051808060200180602001806020018060200180602001806020018060200188810388528f818151815260200191508051906020019080838360005b838110156101945780820151818401525b602081019050610178565b50505050905090810190601f1680156101c15780820380516001836020036101000a031916815260200191505b5088810387528e818151815260200191508051906020019080838360005b838110156101fb5780820151818401525b6020810190506101df565b50505050905090810190601f1680156102285780820380516001836020036101000a031916815260200191505b5088810386528d818151815260200191508051906020019080838360005b838110156102625780820151818401525b602081019050610246565b50505050905090810190601f16801561028f5780820380516001836020036101000a031916815260200191505b5088810385528c818151815260200191508051906020019060200280838360005b838110156102cc5780820151818401525b6020810190506102b0565b5050505090500188810384528b818151815260200191508051906020019060200280838360005b8381101561030f5780820151818401525b6020810190506102f3565b5050505090500188810383528a818151815260200191508051906020019060200280838360005b838110156103525780820151818401525b602081019050610336565b50505050905001888103825289818151815260200191508051906020019060200280838360005b838110156103955780820151818401525b602081019050610379565b505050509050019e50505050505050505050505050505060405180910390f35b34156103c057600080fd5b6103c8611546565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561040c5780820151818401525b6020810190506103f0565b505050509050019250505060405180910390f35b341561042b57600080fd5b61043361174a565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156104745780820151818401525b602081019050610458565b50505050905090810190601f1680156104a15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156104ba57600080fd5b6104e6600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506117f3565b604051808215151515815260200191505060405180910390f35b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b600680549050811015610a9a5760068181548110151561054a57fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415610a8c578460ff166003828154811015156105bd57fe5b90600052602060002090602091828204019190065b9054906101000a900460ff1660ff16148015610613575083600019166004828154811015156105fd57fe5b906000526020600020900160005b505460001916145b80156106445750826000191660058281548110151561062e57fe5b906000526020600020900160005b505460001916145b15610884577fc585b66a303b685f03874907af9278712998ea1acfed37bcb4277da02cddb8b460006001600288888833604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561075f5780601f106107345761010080835404028352916020019161075f565b820191906000526020600020905b81548152906001019060200180831161074257829003601f168201915b505084810383528a8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156107e25780601f106107b7576101008083540402835291602001916107e2565b820191906000526020600020905b8154815290600101906020018083116107c557829003601f168201915b50508481038252898181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156108655780601f1061083a57610100808354040283529160200191610865565b820191906000526020600020905b81548152906001019060200180831161084857829003601f168201915b50509a505050505050505050505060405180910390a160009150610ff4565b7fcb265a1c827beb2fd9947f2a8d4725c8918f266faf695a26a53ac662e42a2f3f600060016002888888604051808060200180602001806020018760ff1660ff1681526020018660001916600019168152602001856000191660001916815260200184810384528a8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156109675780601f1061093c57610100808354040283529160200191610967565b820191906000526020600020905b81548152906001019060200180831161094a57829003601f168201915b50508481038352898181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156109ea5780601f106109bf576101008083540402835291602001916109ea565b820191906000526020600020905b8154815290600101906020018083116109cd57829003601f168201915b5050848103825288818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610a6d5780601f10610a4257610100808354040283529160200191610a6d565b820191906000526020600020905b815481529060010190602001808311610a5057829003601f168201915b5050995050505050505050505060405180910390a160019150610ff4565b5b5b808060010191505061052e565b610aa3336117f3565b15610db85760038054806001018281610abc91906118dd565b91600052602060002090602091828204019190065b87909190916101000a81548160ff021916908360ff1602179055505060048054806001018281610b019190611917565b916000526020600020900160005b869091909150906000191690555060058054806001018281610b319190611917565b916000526020600020900160005b859091909150906000191690555060068054806001018281610b619190611943565b916000526020600020900160005b33909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507fbf474e795141390215f4f179557402a28c562b860f7b74dce4a3c0e0604cd97e600060016002888888604051808060200180602001806020018760ff1660ff1681526020018660001916600019168152602001856000191660001916815260200184810384528a818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610c945780601f10610c6957610100808354040283529160200191610c94565b820191906000526020600020905b815481529060010190602001808311610c7757829003601f168201915b5050848103835289818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610d175780601f10610cec57610100808354040283529160200191610d17565b820191906000526020600020905b815481529060010190602001808311610cfa57829003601f168201915b5050848103825288818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610d9a5780601f10610d6f57610100808354040283529160200191610d9a565b820191906000526020600020905b815481529060010190602001808311610d7d57829003601f168201915b5050995050505050505050505060405180910390a160019150610ff4565b7fc585b66a303b685f03874907af9278712998ea1acfed37bcb4277da02cddb8b460006001600288888833604051808060200180602001806020018860ff1660ff168152602001876000191660001916815260200186600019166000191681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528b818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610ece5780601f10610ea357610100808354040283529160200191610ece565b820191906000526020600020905b815481529060010190602001808311610eb157829003601f168201915b505084810383528a818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610f515780601f10610f2657610100808354040283529160200191610f51565b820191906000526020600020905b815481529060010190602001808311610f3457829003601f168201915b5050848103825289818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610fd45780601f10610fa957610100808354040283529160200191610fd4565b820191906000526020600020905b815481529060010190602001808311610fb757829003601f168201915b50509a505050505050505050505060405180910390a160009150610ff4565b5b509392505050565b61100461196f565b61100c61196f565b61101461196f565b61101c611983565b611024611997565b61102c611997565b6110346119ab565b600061103e6119ab565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fa69efbd6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15156110ce57600080fd5b6102c65a03f115156110df57600080fd5b505050604051805190509250826040518059106110f95750595b908082528060200260200182016040525b509150600090505b8281101561122657600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633ffefe4e826000604051602001526040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b15156111b357600080fd5b6102c65a03f115156111c457600080fd5b5050506040518051905082828151811015156111dc57fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250505b8080600101915050611112565b60006001600260036004600587868054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112c85780601f1061129d576101008083540402835291602001916112c8565b820191906000526020600020905b8154815290600101906020018083116112ab57829003601f168201915b50505050509650858054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113645780601f1061133957610100808354040283529160200191611364565b820191906000526020600020905b81548152906001019060200180831161134757829003601f168201915b50505050509550848054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114005780601f106113d557610100808354040283529160200191611400565b820191906000526020600020905b8154815290600101906020018083116113e357829003601f168201915b505050505094508380548060200260200160405190810160405280929190818152602001828054801561147857602002820191906000526020600020906000905b82829054906101000a900460ff1660ff16815260200190600101906020826000010492830192600103820291508084116114415790505b50505050509350828054806020026020016040519081016040528092919081815260200182805480156114ce57602002820191906000526020600020905b815460001916815260200190600101908083116114b6575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561152457602002820191906000526020600020905b8154600019168152602001906001019080831161150c575b5050505050915099509950995099509950995099505b50505090919293949596565b61154e6119ab565b60006115586119ab565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fa69efbd6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15156115e857600080fd5b6102c65a03f115156115f957600080fd5b505050604051805190509250826040518059106116135750595b908082528060200260200182016040525b509150600090505b8281101561174057600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633ffefe4e826000604051602001526040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b15156116cd57600080fd5b6102c65a03f115156116de57600080fd5b5050506040518051905082828151811015156116f657fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250505b808060010191505061162c565b8193505b50505090565b61175261196f565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117e85780601f106117bd576101008083540402835291602001916117e8565b820191906000526020600020905b8154815290600101906020018083116117cb57829003601f168201915b505050505090505b90565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166363a9c3d7836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156118ba57600080fd5b6102c65a03f115156118cb57600080fd5b5050506040518051905090505b919050565b81548183558181151161191257601f016020900481601f0160209004836000526020600020918201910161191191906119bf565b5b505050565b81548183558181151161193e5781836000526020600020918201910161193d91906119e4565b5b505050565b81548183558181151161196a5781836000526020600020918201910161196991906119bf565b5b505050565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b6119e191905b808211156119dd5760008160009055506001016119c5565b5090565b90565b611a0691905b80821115611a025760008160009055506001016119ea565b5090565b905600a165627a7a72305820b1578e449d72a477a59ce1de032b0dd8a334b883a281e64f0753b819b9ea17b80029a165627a7a723058203859c7b27a7f665c8cc19a029381213ade7e8abb2b3d90961aba70ffddd205eb0029";

    private EvidenceSignersData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private EvidenceSignersData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<NewEvidenceEventEventResponse> getNewEvidenceEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("newEvidenceEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewEvidenceEventEventResponse> responses = new ArrayList<NewEvidenceEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewEvidenceEventEventResponse typedResponse = new NewEvidenceEventEventResponse();
            typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewEvidenceEventEventResponse> newEvidenceEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("newEvidenceEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewEvidenceEventEventResponse>() {
            @Override
            public NewEvidenceEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewEvidenceEventEventResponse typedResponse = new NewEvidenceEventEventResponse();
                typedResponse.addr = (Address) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<Address> getSigner(Uint256 index) {
        Function function = new Function("getSigner", 
                Arrays.<Type>asList(index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> verify(Address addr) {
        Function function = new Function("verify", 
                Arrays.<Type>asList(addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<DynamicArray<Address>> getSigners() {
        Function function = new Function("getSigners", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> newEvidence(Utf8String evi, Utf8String info, Utf8String id, Uint8 v, Bytes32 r, Bytes32 s) {
        Function function = new Function("newEvidence", Arrays.<Type>asList(evi, info, id, v, r, s), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getSignersSize() {
        Function function = new Function("getSignersSize", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<EvidenceSignersData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, DynamicArray<Address> evidenceSigners) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(evidenceSigners));
        return deployAsync(EvidenceSignersData.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<EvidenceSignersData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, DynamicArray<Address> evidenceSigners) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(evidenceSigners));
        return deployAsync(EvidenceSignersData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static EvidenceSignersData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EvidenceSignersData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EvidenceSignersData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EvidenceSignersData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class NewEvidenceEventEventResponse {
        public Address addr;
    }
}
