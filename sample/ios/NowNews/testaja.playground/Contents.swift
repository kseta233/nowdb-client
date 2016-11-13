//: Playground - noun: a place where people can play

import UIKit

func generateOrderList(accessKey: String, type: String, limit:String, offset:String) -> [String:String] {
    let ts = "ts"
    let params: [String : String] = [
        "api_key" : "apikeylaya",
        "ts" : ts,
        "sig" : "temp",
        "access_key":accessKey,
        "type": type,
        "limit": limit,
        "offset" : offset
    ]
    
    //make String URL
    
    return params
}

func genUrlFromParams(params:[String:String])->String{
    var result: String = ""
    
    for param in params {
        result += "\(param.0)=\(param.1)&"
    }
    result.removeAtIndex(result.endIndex.predecessor())
    return result

}

//
//func md5(string string: String) -> String {
//    var digest = [UInt8](count: Int(CC_MD5_DIGEST_LENGTH), repeatedValue: 0)
//    if let data = string.dataUsingEncoding(NSUTF8StringEncoding) {
//        CC_MD5(data.bytes, CC_LONG(data.length), &digest)
//    }
//    
//    var digestHex = ""
//    for index in 0..<Int(CC_MD5_DIGEST_LENGTH) {
//        digestHex += String(format: "%02x", digest[index])
//    }
//    
//    return digestHex
//}
//
//func sha1(string: String) -> String {
//    let data = string.dataUsingEncoding(NSUTF8StringEncoding)!
//    var digest = [UInt8](count:Int(CC_SHA1_DIGEST_LENGTH), repeatedValue: 0)
//    CC_SHA1(data.bytes, CC_LONG(data.length), &digest)
//    let hexBytes = digest.map { String(format: "%02hhx", $0) }
//    return hexBytes.joinWithSeparator("")
//}


print (genUrlFromParams(generateOrderList("aa", type: "aaaa", limit: "aaaaaaa", offset: "a") ))