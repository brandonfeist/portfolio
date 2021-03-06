import * as React from 'react';
import { WithRouterProps } from 'next/dist/client/with-router';
import { NextPageContext } from 'next';
import { auth } from '../utils/auth';

interface AuthSyncProps {
  token: string;
}

// Gets the display name of a JSX component for dev tools
// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
// eslint-disable-next-line @typescript-eslint/no-explicit-any
const getDisplayName = (Component: { displayName: any; name: any }): void =>
  Component.displayName || Component.name || 'Component';

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
// eslint-disable-next-line @typescript-eslint/no-explicit-any
const withAuthSync = (WrappedComponent: any): object => {
  class AuthSync extends React.Component<WithRouterProps & AuthSyncProps> {
    static displayName = `withAuthSync(${getDisplayName(WrappedComponent)})`;

    static async getInitialProps(ctx: NextPageContext): Promise<object> {
      const token = auth(ctx);
      const componentProps =
        WrappedComponent.getInitialProps && (await WrappedComponent.getInitialProps(ctx));

      return { ...componentProps, token };
    }

    render(): JSX.Element {
      return <WrappedComponent {...this.props} />;
    }
  }

  return AuthSync;
};

export default withAuthSync;
