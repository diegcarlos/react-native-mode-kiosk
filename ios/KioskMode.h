
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNKioskModeSpec.h"

@interface KioskMode : NSObject <NativeKioskModeSpec>
#else
#import <React/RCTBridgeModule.h>

@interface KioskMode : NSObject <RCTBridgeModule>
#endif

@end
